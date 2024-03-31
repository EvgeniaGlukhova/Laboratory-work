#include "list.h" 
#include <string>

#ifndef SUBJ_H
#define SUBJ_H

enum ItemType { t_itCar = 1, t_itMinibus, t_itBus, t_itTruck, t_itSpecial };
enum colour { white = 1, black, blue, yellow, red };
enum body { t_itnone = 1, sedan, hatchback, universal };  // кузов
enum engine { t_none = 1, primary, secondary };  // двигатель
enum drive { t_tnone = 1, rear, front, full };  // привад


class Base : public Item {
protected:
    std::string statenumber;  //номер
    std::string owner;  // владелец
    std::string brand; // марка
    std::string model;  // модель
    enum colour col;  // цвет

public:
    std::string getNum() const { return statenumber; }
    std::string getOwn() const { return owner; }
    std::string getBrand() const { return brand; }
    std::string getModel() const { return model; }
    virtual ItemType getType() const = 0;

   
    colour getCol() const { return col; }
    void setCol(colour coll) { col = coll; }

    virtual body getBody() const { return t_itnone; };
    virtual engine getEngine() const { return t_none; };
    virtual drive getDrive() const { return t_tnone; };

    virtual int getLoadCap() const { return 0; };  //груз
    virtual int getNumOfSeats() const { return 0; };  // места
    virtual std::string getText() const { return ""; }  // текст


    virtual void Input();
    virtual void Output() const;
    static ItemType InputType();
    static colour InputCol();
    static body InputBody();
    static engine InputEn();
    static drive InputDrive();

    static Base* Create(List* L, ItemType type);

    bool operator==(const colour& col) const {
        return this->getCol() == col;
    }
    bool operator==(const std::string& str) const {
        return this->statenumber == str;
    }
    bool operator<(const Base& base) const {
        return getNumOfSeats() < base.getNumOfSeats();
    };

    Base(List* L) : Item(L) {};

    virtual ~Base() {};
};

class SubjList : public List {
private:
    void swap(int i, int j);

public:
    void Print() const;
    void sortmecta();
    void FindByNumber(std::string statenumber) const;
    void FindByOwner(std::string owner) const;
    void FindByColour(colour col) const;

    Base& operator[](int n) const;

    ~SubjList() {};
};

#endif
