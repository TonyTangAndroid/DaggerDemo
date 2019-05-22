package demo.dependencies.component;

import com.google.common.truth.Truth;

import org.junit.Test;

import demo.component.shared.Province;

public class ProvinceComponentTest {


    @Test
    public void test_country() {
        CountryComponent countryComponent = DaggerCountryComponent.builder().build();
        ProvinceComponent provinceComponent = DaggerProvinceComponent.builder()
                .countryComponent(countryComponent)
                .build();


        Province province = provinceComponent.province();
        Truth.assertThat(province.provinceName()).isEqualTo("Beijing");
        Truth.assertThat(province.provinceId()).isEqualTo("010");
    }
}