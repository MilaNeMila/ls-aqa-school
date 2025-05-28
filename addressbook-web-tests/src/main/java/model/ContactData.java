package model;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class ContactData {
    public String contactName;
    public String contactMiddleName;
    public String contactLastName;
    public String nicknameContactName;
}