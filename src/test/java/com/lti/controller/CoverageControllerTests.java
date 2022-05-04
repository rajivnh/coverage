package com.lti.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.lti.ExcludeFromJacocoGeneratedReport;
import com.lti.CoverageApplication;
import com.lti.service.CoverageImpl;
import com.lti.service.CoverageService;
import com.lti.store.CoverageData;

import lombok.SneakyThrows;

@SpringBootTest(classes = CoverageApplication.class)
public class CoverageControllerTests {
	@Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;
    
    @MockBean 
    private CoverageService coverageService;
    
    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    
    @ExcludeFromJacocoGeneratedReport
    @SneakyThrows
    @Test
    public void testToConfirmReturnValidData() {
    	Mockito.when(coverageService.find(ArgumentMatchers.isNull())).thenReturn(getJacoData());
    	
    	mockMvc.perform(MockMvcRequestBuilders
    			.get("/find/1234")
    			.accept(MediaType.APPLICATION_JSON)
    			.contentType(MediaType.APPLICATION_JSON))
    			.andDo(print())
    			.andExpect(status().isOk());    	
    }
    
    @ExcludeFromJacocoGeneratedReport
    @SneakyThrows
    @Test
    public void testToConfirmReturnEmptyDataForNull() throws Exception {
    	SoftAssertions assertions = new SoftAssertions();
    	
    	CoverageImpl jacoImpl = new CoverageImpl();
    	
    	assertions.assertThat(jacoImpl.find(null)).isNotNull();
    	assertions.assertThat(jacoImpl.find("1234")).isNotNull();
    	
    	assertions.assertAll();
    }
    
    private CoverageData getJacoData() {
    	return CoverageData.builder()
				.vendorName("ICW-TESTS")
				.build();
    }
}
