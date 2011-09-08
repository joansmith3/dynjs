package org.dynjs.api;

import org.dynjs.runtime.DynAtom;
import org.dynjs.runtime.DynThreadContext;

public interface Function extends DynAtom {

    public DynAtom call(DynThreadContext context, Scope scope, DynAtom... arguments);

}
