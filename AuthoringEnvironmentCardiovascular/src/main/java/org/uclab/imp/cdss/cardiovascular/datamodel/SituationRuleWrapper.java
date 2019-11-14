/*
 Copyright [2016] [Taqdir Ali]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 */
package org.uclab.imp.cdss.cardiovascular.datamodel;

import java.io.Serializable;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Taqdir Ali
 *
 */

public class SituationRuleWrapper implements Serializable {

	public SituationRuleWrapper() {}
	
	private Rule rule = new Rule();
	
	private Situations situations = new Situations();
	
	private User user = new User();
	
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	public Situations getSituations() {
		return situations;
	}
	public void setSituations(Situations situations) {
		this.situations = situations;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
