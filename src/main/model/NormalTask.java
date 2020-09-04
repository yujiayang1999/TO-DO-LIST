package model;

import model.Task;
import ui.NotcorrectType;
import ui.UncorrectException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class  NormalTask extends Task {

    public NormalTask(String name, Boolean status, int duedate, Boolean isnormal) {
        super(name, status, duedate, isnormal);

    }
}

