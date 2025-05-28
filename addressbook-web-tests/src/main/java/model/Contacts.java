package model;

import com.google.common.collect.ForwardingSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class Contacts extends ForwardingSet<ContactData> {
    private Set<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts without(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

    public Contacts withAdd(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }
}