package com.LibraryManagementSystem.LMS.dtos;
import com.LibraryManagementSystem.LMS.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatronDto {
    private Integer id;
    private String name;
    private String contactInfo;

    public static PatronDto from (Patron myPatron){
        return new PatronDto(myPatron.getId(), myPatron.getName(),
                myPatron.getContactInfo());
    }
}