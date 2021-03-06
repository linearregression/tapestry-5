// Copyright 2009, 2010 Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.internal.services;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.PartialMarkupRenderer;

/**
 * Terminator for the {@link org.apache.tapestry5.services.PartialMarkupRenderer} pipeline, which ultimately invokes
 * {@link org.apache.tapestry5.internal.services.PageRenderQueue#renderPartial(org.apache.tapestry5.MarkupWriter, org.apache.tapestry5.json.JSONObject)}
 * .
 * 
 * @since 5.1.0.0
 */
public class PartialMarkupRendererTerminator implements PartialMarkupRenderer
{
    private final PageRenderQueue renderQueue;

    public PartialMarkupRendererTerminator(PageRenderQueue renderQueue)
    {
        this.renderQueue = renderQueue;
    }

    public void renderMarkup(MarkupWriter writer, JSONObject reply)
    {
        // Ensure that whatever renders will do so inside a root element.
        // Omitting this causes NPEs when rendering individual zones
        // of a MultiZoneUpdate

        writer.element("partial-render-root-element");

        renderQueue.renderPartial(writer, reply);

        writer.end();
    }
}
