package model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactData {
    public String id;
    public String contactName;
    public String contactMiddleName;
    public String contactLastName;
    public String nicknameContactName;
}
