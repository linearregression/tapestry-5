// Copyright 2007 The Apache Software Foundation
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

package org.apache.tapestry5.ioc;

import org.apache.tapestry5.ioc.annotations.Marker;

public class MarkerModule
{
    public static void bind(ServiceBinder binder)
    {
        binder.bind(Greeter.class, RedGreeterImpl.class).withId("RedGreeter");
        binder.bind(Greeter.class, UnknownColorGreeterImpl.class).withId("SecondRedGreeter")
                .withMarker(RedMarker.class);
        binder.bind(Greeter.class, RedGreeterImpl.class).withId("SurprisinglyBlueGreeter")
                .withMarker(BlueMarker.class);
        binder.bind(Greeter.class, RedGreeterImpl.class).withId("ColorfulGreeter")
                .withMarker(RedMarker.class, BlueMarker.class);
    }

    @Marker(BlueMarker.class)
    public Greeter build()
    {
        return null;
    }
}
