package color;

public abstract class Color {
    private final String colorName;
    public Color(String color){
        colorName = color;
    }
    public String getColorName(){
        return colorName;
    };
    public boolean equals(Color other){
        return colorName.equals(other.getColorName());
    }
}
