package com.orange.facade.apikataromannumber.controller;

import com.orange.facade.apikataromannumber.bean.response.RomanConversionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArabicToRomanConversionController {
		int [] arabicNumber ={50,40,10,9,5,4,1};
	String [] romanNumber={"C","XL","X","IX","V","IV","I"};

	@GetMapping(value = "/ArabicToRoman")
	public ResponseEntity<RomanConversionResponse> getRomanConversion(@RequestParam(required = true) String valueToConvert) {
		RomanConversionResponse conversionResponse = new RomanConversionResponse();
		conversionResponse.setValueToConvert(String.valueOf(valueToConvert));
		String Roman = "";
		int  arabicValue=Integer.parseInt(valueToConvert);
		for (int i=0;i<arabicNumber.length;i++){
			while(arabicValue >= arabicNumber[i]){
				Roman+=romanNumber[i];
				arabicValue-=arabicNumber[i];
			}
		}
		conversionResponse.setResponse(Roman);
		return new ResponseEntity<>(conversionResponse, HttpStatus.OK);
	}
	}
