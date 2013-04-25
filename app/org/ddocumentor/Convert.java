package org.ddocumentor;


public class Convert {

    public ParsedDocumentation convert(JavaSource javaSource) {
        String s = javaSource.getContent();

        String startDelimiter = "#DocStart";
        int codeDocStart = s.indexOf(startDelimiter) + startDelimiter.length();
        int codeDocEnd = s.indexOf("#DocEnd") - 2;
        CharSequence codeExample = s.subSequence(codeDocStart, codeDocEnd);

        String prettified = new Prettify().prettify(codeExample.toString());
        return new DefaultParsedDocumentation(prettified);
    }


    class DefaultParsedDocumentation implements ParsedDocumentation {
        private String markup;

        DefaultParsedDocumentation(String markup) {
            this.markup = markup;
        }

        @Override
        public String getMarkup() {
            return markup;
        }
    }
}
