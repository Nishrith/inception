/*
 * Copyright 2018
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.inception.ui.kb.stmt.editor;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.eclipse.rdf4j.model.IRI;

import de.tudarmstadt.ukp.clarin.webanno.support.lambda.LambdaAjaxLink;

public class IRIValuePresenter<T extends IRI> extends ValuePresenter<T> {

    private static final long serialVersionUID = -2127902473859929221L;
    
    private IModel<String> stringModel;

    public IRIValuePresenter(String id, IModel<T> model) {
        super(id, model);
        
        stringModel = Model.of();
        
        LambdaAjaxLink link = new LambdaAjaxLink("link",
                this::actionIRILinkClicked);
        link.add(new Label("label", stringModel));
        add(link);
    }
    
    @Override
    protected void onBeforeRender() {
        Object object = getModelObject();
        
        // if the model provides what it promises
        if (object instanceof IRI) {
            IRI iri = (IRI) object;
            stringModel.setObject(iri.getLocalName());
        } else {
            stringModel.setObject(null);
        }
        super.onBeforeRender();
    }
    
    private void actionIRILinkClicked(AjaxRequestTarget target) {
//        send(getPage(), Broadcast.BREADTH, null));
    }
}
