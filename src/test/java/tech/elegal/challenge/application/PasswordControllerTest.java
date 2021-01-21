package tech.elegal.challenge.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkStatusOK() throws Exception
    {
        mockMvc.perform( post( "/api/v1/senha/" )
                                 .content( "AbTp9!fok" ) )
               .andDo( print() )
               .andExpect( status().isOk() );
    }

    @Test
    public void checkValidPassword() throws Exception
    {
        mockMvc.perform( post( "/api/v1/senha/" )
                                 .content( "AbTp9!fok" ) )
               .andDo( print() )
               .andExpect( status().isOk() )
               .andExpect( content().string( containsString( Boolean.TRUE.toString() ) ) );

    }

    @Test
    public void checkInvalidPassword() throws Exception
    {
        mockMvc.perform( post( "/api/v1/senha/" )
                                 .content( "AAbTp9!fok" ) )
               .andDo( print() )
               .andExpect( status().isOk() )
               .andExpect( content().string( containsString( Boolean.FALSE.toString() ) ) );
    }
}