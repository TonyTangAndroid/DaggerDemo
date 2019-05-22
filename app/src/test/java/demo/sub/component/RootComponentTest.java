package demo.sub.component;

import com.google.common.truth.Truth;

import org.junit.Test;

import demo.component.shared.Country;

public class RootComponentTest {


    @Test
    public void test() {

        Truth.assertThat(DaggerCountryComponent.builder().build()).isInstanceOf(CountryComponent.class);
    }

    @Test
    public void test_country() {
        CountryComponent component = DaggerCountryComponent.builder().build();

        {
            Country country = component.country();
            Truth.assertThat(country.countryId()).isEqualTo(1);
            Truth.assertThat(country.countryName()).isEqualTo("China");
        }
        {
            Country country = component.country();
            Truth.assertThat(country.countryId()).isEqualTo(1);
            Truth.assertThat(country.countryName()).isEqualTo("China");
        }
        {

            Country country = component.country();
            Truth.assertThat(country.countryId()).isEqualTo(1);
            Truth.assertThat(country.countryName()).isEqualTo("China");
        }
    }
}