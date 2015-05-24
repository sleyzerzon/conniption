/**
 * Copyright 2013 Cameron Cook
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
package com.celexus.conniption.foreman.util.builder;

import org.scribe.model.Verb;

import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.model.util.MarketQuotesField;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

/**
 * An APIBuilder to handle TradeKing Market calls
 * 
 * @author cam
 * 
 */
public class MarketBuilder extends APIBuilder
{
	private static final long serialVersionUID = -7542591696724178699L;

	private MarketBuilder(Verb v) {
		verb = v;
	}

	public static MarketBuilder getClock(ResponseFormat format)
	{
		MarketBuilder b = new MarketBuilder(Verb.GET);
		b.resourceURL = APICall.getMarketClock(format);
		return b;
	}

	public static MarketBuilder getQuotes(ResponseFormat format, String... symbols)
	{
		return getQuotes(format, symbols, new MarketQuotesResponseField[] {});
	}

	public static MarketBuilder getQuotes(ResponseFormat format, String[] symbols, MarketQuotesResponseField[] fields)
	{
		StringBuilder sb = new StringBuilder();
		for (String sym : symbols)
		{
			sb.append(sym + " ");
		}
		StringBuilder fids = new StringBuilder();
		for (MarketQuotesResponseField f : fields)
		{
			fids.append(f.toString() + " ");
		}
		MarketBuilder b = new MarketBuilder(Verb.POST);
		b.params.put(MarketQuotesField.SYMBOLS.toString(), sb.toString().trim().replace(" ", ","));
		b.resourceURL = APICall.getQuote(ResponseFormat.XML);
		if (!fids.toString().isEmpty())
		{
			b.params.put(MarketQuotesField.FIDS.toString(), fids.toString().trim().replace(" ", ","));
		}
		return b;
	}

}
