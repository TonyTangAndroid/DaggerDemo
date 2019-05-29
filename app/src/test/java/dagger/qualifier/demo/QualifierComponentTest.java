package dagger.qualifier.demo;

import com.google.common.truth.Truth;

import org.junit.Test;

public class QualifierComponentTest {

    @Test
    public void test() {


        QualifierComponent component = DaggerQualifierComponent.create();
        Truth.assertThat(component.sloth()).isEqualTo("sloth");
        Truth.assertThat(component.namedString()).isEqualTo("tony");
        Truth.assertThat(component.scarlettString()).isEqualTo("scarlett");

    }
}