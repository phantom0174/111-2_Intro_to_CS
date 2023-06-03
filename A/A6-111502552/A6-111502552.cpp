/*
Assignment 6
Name: 蕭登鴻
Student Number: 111502552
Course 2023-CE1002-B
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Transaction {
private:
    string name;
    int income = 0, pay = 0;

public:
    Transaction(string name) {
        this->name = name;
    }

    string getName() {
        return name;
    }

    int getIncome() {
        return income;
    }

    int getPay() {
        return pay;
    }

    void setIncome(int income) {
        this->income = income;
    }

    void setPay(int pay) {
        this->pay = pay;
    }
};

int main() {
    vector<Transaction> logs;

    string cmd;
    while (cin >> cmd) {
        if (cmd == "5") break;

        if (cmd == "1") {
            string name;
            int income;
            cin >> name >> income;

            Transaction trans(name);
            trans.setIncome(income);

            logs.push_back(trans);
        } else if (cmd == "2") {
            string name;
            int pay;
            cin >> name >> pay;

            Transaction trans(name);
            trans.setPay(pay);

            logs.push_back(trans);
        } else if (cmd == "3") {
            int sum = 0;
            for (auto trans : logs) {
                cout << trans.getName() << " " << trans.getIncome() << " " << trans.getPay() << endl;
                sum += trans.getIncome() - trans.getPay();
            }
            cout << "Total: " << sum << endl;
        } else if (cmd == "4") {
            int min_value = -1;
            Transaction *min_ptr = nullptr;

            for (int i = 0; i < logs.size(); i++) {
                if (logs[i].getPay() > min_value) min_ptr = &logs[i];
            }
            if (min_ptr == nullptr) continue;

            cout << (*min_ptr).getName() << " " << (*min_ptr).getIncome() << " " << (*min_ptr).getPay() << endl;
        } else {
            cout << "Invalid Operation" << endl;
        }
    }
}
