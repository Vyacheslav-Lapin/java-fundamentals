package com.epam.courses.java.fundamentals.oop.practice.task6;

public enum Subject {
  MATHEMATICS {
    @Override
    public boolean isMarkInteger() {
      return false;
    }
  },
  HISTORY{
    @Override
    public boolean isMarkInteger() {
      return true;
    }
  },
  BIOLOGY{
    @Override
    public boolean isMarkInteger() {
      return true;
    }
  },
  CHEMISTRY{
    @Override
    public boolean isMarkInteger() {
      return false;
    }
  },
  LITERATURE{
    @Override
    public boolean isMarkInteger() {
      return false;
    }
  },
  LANGUAGES{
    @Override
    public boolean isMarkInteger() {
      return true;
    }
  },
  MUSIC{
    @Override
    public boolean isMarkInteger() {
      return false;
    }
  };

  public abstract boolean isMarkInteger();
}
