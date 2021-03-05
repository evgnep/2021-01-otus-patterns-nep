package su.nepom.patterns.home1.model.object;

import org.junit.Test;
import su.nepom.patterns.home1.model.UObject;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UObjectImplTest {

    interface Interface1 {}
    interface Interface2 {}
    interface Interface3 {}
    interface Interface4 {}

    static class InterfaceImpl implements Interface1, Interface2, Interface3, UObject.Part {
        @Override
        public List<Class<?>> canQueryAs() {
            return null;
        }
    }

    @Test
    public void queryInterface() {
        var impl1 = mock(InterfaceImpl.class);
        var impl2 = mock(InterfaceImpl.class);

        when(impl1.canQueryAs()).thenReturn(List.of(Interface1.class, Interface2.class));
        when(impl2.canQueryAs()).thenReturn(List.of(Interface3.class));

        var obj = new UObjectImpl(impl1, impl2);

        assertEquals(Optional.of(impl1), obj.queryInterface(Interface1.class));
        assertEquals(Optional.of(impl1), obj.queryInterface(Interface2.class));
        assertEquals(Optional.of(impl2), obj.queryInterface(Interface3.class));
        assertEquals(Optional.empty(), obj.queryInterface(Interface4.class));
    }
}