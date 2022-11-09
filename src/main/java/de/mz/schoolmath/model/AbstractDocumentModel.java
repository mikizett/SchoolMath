package de.mz.schoolmath.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.PropertyChangeEvent;

@Setter
@Getter
@NoArgsConstructor
public abstract class AbstractDocumentModel implements IDocumentModel {
    private int fromNo;
    private int toNo;
    private int columnAmount;
    private int pageAmount;
    private int totalSum;

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
    }
}
