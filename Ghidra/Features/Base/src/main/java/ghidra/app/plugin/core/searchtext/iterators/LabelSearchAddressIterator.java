/* ###
 * IP: GHIDRA
 * REVIEWED: YES
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.app.plugin.core.searchtext.iterators;

import ghidra.program.model.address.Address;
import ghidra.program.model.address.AddressIterator;
import ghidra.program.model.symbol.Symbol;
import ghidra.program.model.symbol.SymbolIterator;

import java.util.Iterator;

public class LabelSearchAddressIterator implements AddressIterator {

	private SymbolIterator labelIterator;

	public LabelSearchAddressIterator(SymbolIterator labelIterator) {
		this.labelIterator = labelIterator;
	}

	@Override
	public boolean hasNext() {
		return labelIterator.hasNext();
	}

	@Override
	public Address next() {
		Symbol symbol = labelIterator.next();
		return symbol.getAddress();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Address> iterator() {
		return this;
	}
}
