package com.example.mecz.model;

import com.example.mecz.model.piłkarz.Piłkarz;
import com.example.mecz.model.trener.Trener;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Drużyna {
    private Ustawienie ustawienie;
    private List<Piłkarz> piłkarze;
    private Trener trener;

    public Drużyna(Ustawienie ustawienie, List<Piłkarz> piłkarze, Trener trener ){
        this.ustawienie = ustawienie;
        this.piłkarze = piłkarze;
        this.trener = trener;
    }

    //TODO:składa się z 11 piłkarzy w zależności od (wylosowanego, wybranego w controlerze?) ustawienia i trenera

    //TODO: trenera stworzyc, stworzyć kadrę 25 piłkarzy z podziałem na pozycje - listapiłkarzy, , drużynaserwis zrobić żeby z kadry się pobrali do drużyny - listapiłkarzy drużyna z trenerem
    // w zależności od ustawienia, [na początku się losuje a później możemy zmienić controllerem i żeby sprawdziło który piłkarz na danej pozycji jest najlepszy
    // + rezerw, to przed każdym meczem sprawdza czy ktoś jest zawieszony, kontuzjowany, kondycja] +(nazwaserwis) - DRUGA APKA

    //TODO: stworzyć serwis tworzący piłkarzy , wypisać całą kadrę z pozycją, jak się zrobi drużyna (ustawnie, piłkarze, terener) to pomyśleć nad controllerem
    // ( w postmanie co wpiszę to taka drużyna się losuje) później stworzenie innych drużyn z którymi się będzie grało, można założyc gita pod to, stworzyć mastera a jak robię
    // pojedyncze zadania (np. tworzenie drużyny) to zrobić na innym branch'u i tak dalej z innymi zadaniami


}
