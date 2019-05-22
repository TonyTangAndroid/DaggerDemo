package demo.sub.component;

import com.google.common.truth.Truth;

import org.junit.Test;

public class ProvinceComponentTest {


    @Test
    public void test_country() {
        CountryComponent countryComponent = DaggerCountryComponent.builder().build();

        ProvinceComponent provinceComponent = countryComponent.provinceComponentBuilder().build();
        Province province = provinceComponent.province();
        Truth.assertThat(province.provinceName()).isEqualTo("Beijing");
        Truth.assertThat(province.provinceId()).isEqualTo("010");
    }
}