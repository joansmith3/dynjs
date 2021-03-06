package org.dynjs.runtime;

import static org.fest.assertions.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;

public class DeleteOpTest extends AbstractDynJSTestSupport {

    @Test
    @Ignore
    // FIXME strict-related?
    public void testDeleteObject() {
        eval("var x = {}; delete x;");
        Reference x = getContext().resolve("x");
        assertThat(x.isUnresolvableReference()).isFalse();
    }

    @Test
    public void testDeleteObjectProperty() {
        eval("var x = { foo: 'taco' };");
        JSObject x = (JSObject) getContext().resolve("x").getValue(getContext());
        assertThat(x.get(getContext(), "foo")).isEqualTo("taco");
        Object result = eval("delete x.foo");
        assertThat(result).isEqualTo(true);
        assertThat(x.get(getContext(), "foo")).isEqualTo(Types.UNDEFINED);
    }
    
    @Test
    public void testDeleteThis() {
        Object result = eval( "delete this" );
    }

}
