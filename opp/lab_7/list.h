#pragma once
class List;

class Item {
private:
	Item* next;
	Item* prev;
	List* list;
public:
	Item* Next() const { 
		return next;
	}
	Item* Prev() const { 
		return prev;
	}

	friend class List;


	Item(List* L) : next(nullptr), prev(nullptr), list(L) {};

	virtual ~Item(); 
};

class List {
private:
	Item* head;
	Item* tail;
public:
	Item* Head() const { 
		return head;
	}
	Item* Tail() const { 
		return tail;
	}

	void Add(Item* I);
	int Count() const; 
	Item* GetItem(int n) const; 
	int GetIndex(Item* I) const; 
	Item* Remove(Item* I); 
	Item* Remove(int n);
	void Delete(int n);
	void Clear();
	void Insert(Item* I, int n);

	List() : head(nullptr), tail(nullptr) {};

	virtual ~List();
};
