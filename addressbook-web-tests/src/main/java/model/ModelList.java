package model;

import com.google.common.collect.ForwardingSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@With
@AllArgsConstructor
public class ModelList<T> extends ForwardingSet<T> {
    private Set<T> delegate;

    public ModelList(ModelList modelList) {
        this.delegate = new HashSet<T>(modelList.delegate);
    }

    public ModelList() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<T> delegate() {
        return delegate;
    }

    public ModelList without(T object) {
        ModelList list = new ModelList(this);
        list.remove(object);
        return list;
    }
    public ModelList withAdd(T object) {
        ModelList list = new ModelList(this);
        list.add(object);
        return list;
    }
}