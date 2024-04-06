#pragma once
class List;

class Item {
private:
	Item* next;
	Item* prev;
	List* list;
public:
	Item* Next() {
		return next;
	}
	Item* Prev() {
		return prev;
	}

	friend class List;


	Item(List* L) : next(nullptr), prev(nullptr), list(L) {};

	~Item();
};

class List {
private:
	Item* head;
	Item* tail;
public:
	Item* Head() {
		return head;
	}
	Item* Tail() {
		return tail;
	}

	void Add(Item* I);
	int Count();
	Item* GetItem(int n);
	int GetIndex(Item* I);
	Item* Remove(int n);
	void Delete(int n);
	void Clear();
	void Insert(Item* I, int n);

	List() : head(nullptr), tail(nullptr) {};


	~List();
};
