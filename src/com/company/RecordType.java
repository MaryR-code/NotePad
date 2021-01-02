package com.company;

public enum RecordType {
    PERSON {
        @Override
        public Record createRecord() {
            return new Person();
        }
    },
    BOOK {
        @Override
        public Record createRecord() {
            return new Book();
        }
    },
    NOTE {
        @Override
        public Record createRecord() {
            return new StickyNote();
        }
    },
    ALARM {
        @Override
        public Record createRecord() {
            return new RecurringAlarm();
        }
    },
    REMINDER {
        @Override
        public Record createRecord() {
            return new Reminder();
        }
    },
    PET {
        @Override
        public Record createRecord() {
            return new Pet();
        }
    };

    public abstract Record createRecord();
}
