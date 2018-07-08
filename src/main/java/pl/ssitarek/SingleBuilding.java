package pl.ssitarek;

class SingleBuilding implements Comparable<SingleBuilding> {

    private int number;
    private int height;

    public SingleBuilding(int number, int height) {

        this.number = number;
        this.height = height;
    }

    public int compareTo(SingleBuilding b) {

        if (height == b.height) {
            return number - b.number;
        }
        return b.height - height;
    }

    public int getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }
}
