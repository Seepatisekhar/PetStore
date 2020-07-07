/*
 * package com.example.petstore.serviceimpl;
 * 
 * import static org.junit.jupiter.api.Assertions.assertTrue; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.jupiter.MockitoExtension;
 * 
 * import com.example.petstore.dao.PetDao; import
 * com.example.petstore.dto.LoginDto; import
 * com.example.petstore.dto.PetListResponseDto; import
 * com.example.petstore.exception.InvalidCredentialsException; import
 * com.example.petstore.model.Pet; import
 * com.example.petstore.serviceImpl.PetServiceImpl;
 * 
 * @ExtendWith(MockitoExtension.class) public class PetsServiceImpl {
 * 
 * Optional<List<Pet>> pet;
 * 
 * @Mock PetDao petDao;
 * 
 * @InjectMocks PetServiceImpl petServiceImpl;
 * 
 * PetListResponseDto petListResponseDto; LoginDto loginDto;
 * 
 * @BeforeEach public void setUp() {
 * 
 * }
 * 
 * 
 * @Test public void getPetsByPetName() throws InvalidCredentialsException {
 * PetListResponseDto responseDto = new PetListResponseDto();
 * responseDto.setMessage("correct"); responseDto.setStatusCode(400);
 * petServiceImpl.getPetsByPetName("dog");
 * verify(petDao).findAllByPetName("dog"); } }
 */