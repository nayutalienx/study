public interface SportSchool {
    int getSchoolId();
    int getAmountOfSections();
    void setSchoolId(int id);
    void setAmountOfSections(int n);
    Section getSection(int key);
    void addSection(Section s);
    void delSection(int key);
    double getAveragePrice();
    SportSchool getPriceLowerAverage();
    SportSchool getPriceByInterval(double x, double y);
    void printList();
    SportSchool getSortedByPrice();
}
