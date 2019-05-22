package demo.sub.component;

import com.google.common.truth.Truth;

import org.junit.Test;

public class ProvinceComponentTest {


    @Test
    public void test_country() {
        CountryComponent countryComponent = DaggerCountryComponent.builder().build();


        {

            Country country = countryComponent.country();
            Truth.assertThat(country.countryId()).isEqualTo(1);
            Truth.assertThat(country.countryName()).isEqualTo("China");
        }
        {

            Truth.assertThat(DaggerProvinceComponent.builder().build().province())
                    .isNotNull();

        }

    }
}