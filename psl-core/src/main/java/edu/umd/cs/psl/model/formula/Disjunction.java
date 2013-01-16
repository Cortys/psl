/*
 * This file is part of the PSL software.
 * Copyright 2011 University of Maryland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.umd.cs.psl.model.formula;

import java.util.ArrayList;

public class Disjunction extends AbstractBranchFormula {

	public Disjunction(Formula... f) {
		super(f);
	}
	
	@Override
	public Formula getDNF() {
		Formula[] components = new Formula[getNoFormulas()];
		for (int i = 0; i < components.length; i++)
			components[i] = get(i).getDNF();
		return new Disjunction(components);
	}

	@Override
	protected String separatorString() {
		return "v";
	}
	
	/**
	 * Collapses nested Disjunctions.
	 * <p>
	 * Stops descending where ever a Formula other than a Disjunction is.
	 * 
	 * @return the flattened Disjunction
	 */
	public Disjunction flatten() {
		ArrayList<Formula> disj = new ArrayList<Formula>(getNoFormulas());
		for (Formula f : formulas) {
			if (f instanceof Disjunction) {
				Formula[] newFormulas = ((Disjunction) f).flatten().formulas;
				for (Formula newF : newFormulas)
					disj.add(newF);
			}
			else
				disj.add(f);
		}
		return new Disjunction((Formula[]) disj.toArray(new Formula[disj.size()]));
	}

}
