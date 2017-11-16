public enum Answer {

    YES(true),yes(true),tak(true),si(true),oui(true),yep(true),da(true),hai(true),TAK(true),
    nie(false),no(false),NO(false),nain(false), niet(false), nope(false),non(false),NIE(false);

    private boolean correct;

    Answer(boolean correct){
        this.correct=correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }
}
