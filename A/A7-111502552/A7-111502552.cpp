/*
Assignment 7
Name: 蕭登鴻
Student Number: 111502552
Course 2023-CE1002-B
*/



#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Behavior {
private:
    int feeding_habits;
    string activity_time;

public:
    Behavior(int feed, string act) {
        feeding_habits = feed;
        activity_time = act;
    }

    Behavior() {
        feeding_habits = 2;
        activity_time = "day";
    }

    void setFeeding(int new_feed) {
        feeding_habits = new_feed;
    }

    void setAct(string new_act) {
        activity_time = new_act;
    }

    int getFeed() const {
        return feeding_habits;
    }

    string getAct() const {
        return activity_time;
    }
};


vector<string> transFeed = {
    "herbivorous",
    "carnivorous",
    "omnivorous"
};


class Species {
private:
    const string name;
    string category;
    Behavior behavior;
    int number;

public:
    Species(): name("human") {
        category = "Primates";
        number = 100;
    }

    Species(const string name, const string cate, const Behavior behav, int num): name(name) {
        category = cate;
        behavior = behav;
        number = num;
    }

    Species(const string name, const string cate, const int feed, const string act, const int num):
        name(name),
        behavior(feed, act) {
        category = cate;
    }

    ~Species() {
        cout << "species " << name << " is deleted" << endl;
    }

    string getName() const {
        return name;
    }

    string getCate() const {
        return category;
    }

    Behavior getBeh() const {
        return behavior;
    }

    int getNum() const {
        return number;
    }

    void setCate(string new_cate) {
        category = new_cate;
    }

    void setBeh(Behavior new_behav) {
        behavior = new_behav;
    }

    void setNum(int new_num) {
        number = new_num;
    }

    void showInfo() const {
        cout << name << " " << category << " " << transFeed[behavior.getFeed()] << " " << behavior.getAct() << " " << number << endl;
    }
};


int main() {
    int feed, number;
    string name, cate, act;
    

    Species s1;

    // s2
    cout << "please input behavior info (feeding_habits/activity_time)" << endl;
    cin >> feed >> act;
    Behavior s2_behav(feed, act);

    cout << "please input species2 info(name/category/number)" << endl;
    cin >> name >> cate >> number;

    Species s2(name, cate, s2_behav, number);
    // ~s2

    // s3
    cout << "please input species3 info(name/category/feeding_habits/activity_time/number)" << endl;
    cin >> name >> cate >> feed >> act >> number;

    Species s3(name, cate, feed, act, number);
    // ~s3


    string cmd;
    while (true) {
        cout << "1.change species info 2.show all species info 3.exit" << endl;
        cin >> cmd;

        if (cmd == "3") break;

        if (cmd == "1") {
            int tar;
            cout << "which species would you like to change(1/2/3)?" << endl;
            cin >> tar;

            cout << "input new info (category/feeding_habits/activity_time/number)" << endl;
            cin >> cate >> feed >> act >> number;

            Species *tar_spec = nullptr;
            if (tar == 1) tar_spec = &s1;
            else if (tar == 2) tar_spec = &s2;
            else if (tar == 3) tar_spec = &s3;

            tar_spec->setCate(cate);

            Behavior new_behav(feed, act);
            tar_spec->setBeh(new_behav);
            tar_spec->setNum(number);
        } else if (cmd == "2") {
            s1.showInfo();
            s2.showInfo();
            s3.showInfo();
        }
    }
}