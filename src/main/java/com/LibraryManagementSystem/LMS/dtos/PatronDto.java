package com.LibraryManagementSystem.LMS.dtos;
import com.LibraryManagementSystem.LMS.entities.Patron;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatronDto {
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;
    @NotBlank(message = "Contact information is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid contact information format")
    private String contactInfo;

    public static PatronDto from (Patron myPatron){
        return new PatronDto(myPatron.getId(), myPatron.getName(),
                myPatron.getContactInfo());
    }
}