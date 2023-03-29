package com.orange.facade.apikataromannumber.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.*;
import org.springframework.http.ResponseEntity;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;

@ExtendWith(MockitoExtension.class)
class ArabicToRomanConversionControllerTest {

	@InjectMocks
	ArabicToRomanConversionController controller;

	@Test
	void testGetRomanConversion_convert_1_to_I() {
		//setup
		Integer valueToConvert = 1;
		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));
		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("1");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("I");
	}
	@Test
	void testGetRomanConversion_convert_5_to_V() {
		//setup
		Integer valueToConvert = 5;
		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));
		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("5");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("V");
	}

	@Test
	void testGetRomanConversion_convert_10_to_X() {
		//setup
		Integer valueToConvert = 10;
		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));
		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("10");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("X");
	}

	@Test
	void testGetRomanConversion_convert_50_to_C() {
		//setup
		Integer valueToConvert = 50;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));

		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("50");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("C");
	}

	@Test
	void testGetRomanConversion_convert_4_to_IV() {
		//setup
		Integer valueToConvert = 4;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));

		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("4");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("IV");
	}

	@Test
	void testGetRomanConversion_convert_49_to_IV() {
		//setup
		Integer valueToConvert = 49;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));

		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("49");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("XLIX");
	}


	@Test
	void testGetRomanConversion_convert_38_to_IV() {
		//setup
		Integer valueToConvert = 38;

		//Test
		ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));

		//Assert
		assertThat(romanConversion.getBody().getValueToConvert()).isEqualTo("38");
		assertThat(romanConversion.getBody().getResponse()).isEqualTo("XXXVIII");
	}


	@Test
	void testGetRomanConversion_test_null_value() {
		//setup
		Integer valueToConvert = null;
		try
		{
			ResponseEntity<RomanConversionResponse> romanConversion = controller.getRomanConversion(String.valueOf(valueToConvert));
			//Assert
			assertThat(romanConversion.getStatusCodeValue()).isEqualTo(404);
			assertThat(romanConversion.getBody()).isNotNull();
			assertThat(romanConversion.getBody().getValueToConvert()).isNullOrEmpty();
			assertThat(romanConversion.getBody().getResponse()).isNullOrEmpty();
		}
		catch(NullPointerException Exception)
		{
			System.out.print("NullPointerException Caught");
		}


	}

}
