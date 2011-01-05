/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jingguo.url;

import java.net.URL;

import org.antlr.runtime.CommonTokenStream;
import org.junit.Test;

public class URLTest {

    @Test
    public void testParse() throws Exception {
        parse("http://www.google.com");
        parse("http://www.google.com:8080");
        parse("http://11.22.33.44:8080");
        parse("http://www.tianya.cn?name=yaojg");
        parse("http://www.tianya.cn?name=yaojg&no=1");
        parse("http://www.tianya.cn?name=yao%2ajg&no=1");
        parse("http://www.tianya.cn?name=yaojg&no=1#details");
        parse("http://www.tianya.cn:8080/one/def?name=yaojg&no=1#details");
    }

    /*
     * Show the usage of java.net.URL.
     */
    @Test
    public void testJavaURL() throws Exception {
        URL url = new URL("http://www.tianya.cn:8080/one/def?name=jingguo&no=1#details");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getAuthority());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
    }
    
    private void parse(String s) throws Exception {
        URLLexer lexer = new URLLexer(s);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        URLParser parser = new URLParser(tokens);
        parser.url();
        System.out.println(parser.getURL());
    }
}
