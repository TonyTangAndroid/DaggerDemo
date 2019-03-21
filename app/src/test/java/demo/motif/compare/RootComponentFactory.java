/*
 * Copyright (c) 2018 Uber Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.motif.compare;

import android.content.Context;

import demo.common.ViewGroup;

/**
 * This is a convenience Scope defined simply to build the RootScope. This additional layer is useful since RootScope
 * requires a Context that must be provided from outside of the graph. RootComponentFactory can declare an empty @Dependencies
 * interface and pass the ViewGroup in to the RootScope child method. In RootActivity, we now have a nice API to
 * instantiate the RootScope.
 */
@motif.Scope
public interface RootComponentFactory {

    RootComponent create(ViewGroup viewGroup);

    @motif.Dependencies
    interface Dependencies {}
}
