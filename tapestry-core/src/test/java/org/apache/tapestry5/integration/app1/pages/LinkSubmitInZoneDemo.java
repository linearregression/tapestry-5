// Copyright 2009 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.integration.app1.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Zone;

import java.util.Date;

public class LinkSubmitInZoneDemo
{
    @Property
    @Validate("required")
    private String value;
    
    @Property
    @Persist(PersistenceConstants.FLASH)
    private boolean eventfired;

    @InjectComponent
    private Zone output;
    
    void onSelectedFromMySubmit()
    {
        eventfired = true;
    }

    Object onSuccess()
    {
        return output.getBody();
    }

    public Date getNow()
    {
        return new Date();
    }
}
