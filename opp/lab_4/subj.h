#include <string>

#ifndef SUBJ_H
#define SUBJ_H

enum ItemType { itCar = 1, itMinibus, itBus, itTruck, itSpecial };
enum colour { white = 1, black, blue, yellow, red };
enum body { sedan = 1, hatchback, universal };
enum engine { primary = 1, secondary };
enum drive { rear = 1, front, full };


class Base : public Item {
protected:
    ItemType type;
    std::string statenumber;
    std::string owner;
    std::string brand;
    std::string model;
    enum colour col;
    void _input();
    void _output();

public:
    ItemType getType() { return type; }
    std::string getNum() { return statenumber; }
    std::string getOwn() { return owner; }
    std::string getBrand() { return brand; }
    std::string getModel() { return model; }
    colour getCol() { return col; }

    void setType(ItemType tip) { type = tip; }
    void setCol(colour coll) { col = coll; }

    void Input();
    void Output();

    static Base* Create(List* L, ItemType type);
    Base(List* L) : Item(L) {};

    virtual ~Base() {};
};

class SubjList : public List {
private:
    void swap(int i, int j);
    // bool compare(Base* i, Base* j);


public:
    void Print();
    void sortmecta();
    void FindByNumber(std::string statenumber);
    void FindByOwner(std::string owner);
    void FindByColour(colour col);
    virtual ~SubjList() {};
};

ItemType InputType();


#endif
