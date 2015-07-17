package org.mingle.banana.spring.knights;

public class DamselRescuingKnight implements Knight {
	private RescueDamselQuest quest;

	public DamselRescuingKnight() {
		quest = new RescueDamselQuest(); // <co id="co_coupledToQuest"/>
	}

	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}
}
