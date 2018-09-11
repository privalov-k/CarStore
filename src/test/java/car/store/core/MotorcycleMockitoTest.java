package car.store.core;

import car.store.controller.MotorcycleController;
import car.store.model.Motorcycle;
import car.store.service.MotorcycleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//TODO сделать тесты
public class MotorcycleMockitoTest {

    private MockMvc mockMvc;

    @Mock
    private MotorcycleService motorcycleService;

    @InjectMocks
    private MotorcycleController motorcycleController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(motorcycleController)
                .build();
    }

    @Test
    public void test_deleteMoto() throws Exception {
       Integer id = 1;

       mockMvc.perform(get("/motorcycle/delete/1")).andExpect(status().isOk());
       verify(motorcycleService, times(1)).delete(id);
    }

    @Test
    public void test_getMoto() throws Exception{
        Integer id = 1;
        when(motorcycleService.get(id)).thenReturn(new Motorcycle());

        mockMvc.perform(get("/motorcycle/get/1")).andExpect(status().isOk());

    }

    @Test
    public void test_addMoto() throws Exception{
        verifyZeroInteractions(motorcycleService);

        mockMvc.perform(get("/motorcycle/add")).andExpect(status().isOk());
    }


}
