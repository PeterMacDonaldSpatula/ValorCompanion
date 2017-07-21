package petermacdonald.valorgmcompanion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import petermacdonald.valorgmcompanion.character.ValorCharacter;
import petermacdonald.valorgmcompanion.character.enums.CharacterType;
import petermacdonald.valorgmcompanion.character.flaws.Flaw;
import petermacdonald.valorgmcompanion.character.flaws.LackOfControl;
import petermacdonald.valorgmcompanion.character.flaws.Oblivious;
import petermacdonald.valorgmcompanion.character.flaws.WeakEnergyAttacker;
import petermacdonald.valorgmcompanion.character.skills.DangerSense;
import petermacdonald.valorgmcompanion.character.skills.Skill;
import petermacdonald.valorgmcompanion.character.skills.Tough;

public class CharacterSheet extends AppCompatActivity {

    ValorCharacter character;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
        GridLayout g = (GridLayout)findViewById(R.id.statBlock);
        int screenWidth = getScreenWidth();
        int cellWidth = screenWidth / 10;
        int margin = cellWidth / 10;
        GridLayout.LayoutParams p;
        String numberTag = getResources().getString(R.string.numberTag);
        for(int i = 0; i < g.getChildCount(); i++){
            p = (GridLayout.LayoutParams) g.getChildAt(i).getLayoutParams();
            p.setMargins(margin, 1, margin, 1);
            if(g.getChildAt(i).getTag() != null && !((String) g.getChildAt(i).getTag()).equals(numberTag)) {
                p.width = cellWidth;
            }
        }

        character = new ValorCharacter("Brianna", CharacterType.ELITE, 10);
        character.setStrength(17);
        character.setAgility(9);
        character.setSpirit(17);
        character.setMind(2);
        character.setGuts(7);

        character.addFlaw(new Oblivious());
        character.addFlaw(new LackOfControl(character));
        character.addFlaw(new WeakEnergyAttacker(character));

        character.addSkill(new DangerSense());
        character.addSkill(new Tough(character));

        EditText text;

        text = (EditText) findViewById(R.id.strengthView);
        text.setText(String.valueOf(character.getStrength()));

        text = (EditText) findViewById(R.id.agilityView);
        text.setText(String.valueOf(character.getAgility()));

        text = (EditText) findViewById(R.id.spiritView);
        text.setText(String.valueOf(character.getSpirit()));

        text = (EditText) findViewById(R.id.mindView);
        text.setText(String.valueOf(character.getMind()));

        text = (EditText) findViewById(R.id.gutsView);
        text.setText(String.valueOf(character.getGuts()));

        setTextFields();

        EditText et = (EditText) findViewById(R.id.strengthView);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    character.setStrength(0);
                } else {
                    character.setStrength(Integer.parseInt(s.toString()));
                }
                setTextFields();
            }
        });

        et = (EditText) findViewById(R.id.agilityView);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    character.setAgility(0);
                } else {
                    character.setAgility(Integer.parseInt(s.toString()));
                }
                setTextFields();
            }
        });

        et = (EditText) findViewById(R.id.spiritView);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    character.setSpirit(0);
                } else {
                    character.setSpirit(Integer.parseInt(s.toString()));
                }
                setTextFields();
            }
        });

        et = (EditText) findViewById(R.id.mindView);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    character.setMind(0);
                } else {
                    character.setMind(Integer.parseInt(s.toString()));
                }
                setTextFields();
            }
        });

        et = (EditText) findViewById(R.id.gutsView);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    character.setGuts(0);
                } else {
                    character.setGuts(Integer.parseInt(s.toString()));
                }
                setTextFields();
            }
        });

        generateFlawsList(character.getFlaws(), (ViewGroup) findViewById(R.id.flawsList));
        generateSkillsList(character.getSkills(), (ViewGroup) findViewById(R.id.skillsList));

        /*LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View inflated = inflater.inflate(R.layout.character_sheet_flaw_box, (LinearLayout) findViewById(R.id.flawsList));*/
    }

    private int getScreenWidth(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return  size.x;
    }

    private void setTextFields() {
        TextView text;

        text = (TextView) findViewById(R.id.characterName);
        text.setText(character.getName());

        text = (TextView) findViewById(R.id.characterDescription);
        text.setText("Level " + character.getLevel() + " " + character.getType());

        text = (TextView) findViewById(R.id.muscleView);
        text.setText(String.valueOf(character.getMuscle()));

        text = (TextView) findViewById(R.id.dexterityView);
        text.setText(String.valueOf(character.getDexterity()));

        text = (TextView) findViewById(R.id.auraView);
        text.setText(String.valueOf(character.getAura()));

        text = (TextView) findViewById(R.id.intuitionView);
        text.setText(String.valueOf(character.getIntuition()));

        text = (TextView) findViewById(R.id.resolveView);
        text.setText(String.valueOf(character.getResolve()));

        text = (TextView) findViewById(R.id.strengthAttackView);
        text.setText(String.valueOf(character.getStrengthAttack()));

        text = (TextView) findViewById(R.id.agilityAttackView);
        text.setText(String.valueOf(character.getAgilityAttack()));

        text = (TextView) findViewById(R.id.spiritAttackView);
        text.setText(String.valueOf(character.getSpiritAttack()));

        text = (TextView) findViewById(R.id.mindAttackView);
        text.setText(String.valueOf(character.getMindAttack()));

        text = (TextView) findViewById(R.id.healthView);
        text.setText(String.valueOf(character.getHealth()));

        text = (TextView) findViewById(R.id.staminaView);
        text.setText(String.valueOf(character.getStamina()));

        text = (TextView) findViewById(R.id.defenseView);
        text.setText(String.valueOf(character.getDefense()));

        text = (TextView) findViewById(R.id.resistanceView);
        text.setText(String.valueOf(character.getResistance()));

        text = (TextView) findViewById(R.id.speedView);
        text.setText(String.valueOf(character.getSpeed()));

        text = (TextView) findViewById(R.id.healthIncrementView);
        text.setText(String.valueOf(character.getHealthIncrement()));

        text = (TextView) findViewById(R.id.staminaIncrementView);
        text.setText(String.valueOf(character.getStaminaIncrement()));

        text = (TextView) findViewById(R.id.criticalHealthView);
        text.setText(String.valueOf(character.getCriticalHealth()));

        text = (TextView) findViewById(R.id.damageIncView);
        text.setText(String.valueOf(character.getDamageIncrement()));

        text = (TextView) findViewById(R.id.initiativeView);
        text.setText(String.valueOf(character.getInitiative()));
    }

    private void generateFlawsList(List<Flaw> flawsList, ViewGroup list) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resources res = getResources();
        View inflated;
        TextView textView;
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (Flaw currentFlaw:flawsList) {
            inflated = (View) inflater.inflate(R.layout.character_sheet_flaw_box, null);

            textView = (TextView) inflated.findViewById(R.id.flawName);
            textView.setText(currentFlaw.getName());

            textView = (TextView) inflated.findViewById(R.id.flawLevel);
            textView.setText(res.getString(R.string.flawLevelTemplate, currentFlaw.getLevel()));

            textView = (TextView) inflated.findViewById(R.id.flawValue);
            textView.setText(res.getString(R.string.flawValueTemplate, currentFlaw.getValue()));

            textView = (TextView) inflated.findViewById(R.id.flawEffect);
            textView.setText(currentFlaw.getDescription());

            inflated.setLayoutParams(lp);
            list.addView(inflated);
        }
    }

    private void generateSkillsList(List<Skill> skillsList, ViewGroup list) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resources res = getResources();
        View inflated;
        TextView textView;
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for(Skill currentSkill:skillsList) {
            inflated = (View) inflater.inflate(R.layout.character_sheet_skill_box, null);

            textView = (TextView) inflated.findViewById(R.id.skillName);
            textView.setText(currentSkill.getName());

            textView = (TextView) inflated.findViewById(R.id.skillLevel);
            textView.setText(res.getString(R.string.skillLevelTemplate, currentSkill.getLevel()));

            textView = (TextView) inflated.findViewById(R.id.skillCost);
            textView.setText(res.getString(R.string.skillCostTemplate, currentSkill.getCost()));

            textView = (TextView) inflated.findViewById(R.id.skillEffect);
            textView.setText(currentSkill.getDescription());

            inflated.setLayoutParams(lp);
            list.addView(inflated);
        }

    }
}
