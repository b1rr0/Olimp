package diploma_researches;

import java.util.Random;

enum RelationType {
    PARENT,
    CHILD,
    SIBLING,
    FRIEND,
    COLLEAGUE,
    NEIGHBOR,
    PARTNER,
    SPOUSE,
    COUSIN,
    UNCLE,
    AUNT,
    GRANDPARENT,
    GRANDCHILD,
    ACQUAINTANCE,
    CLASSMATE,
    TEAMMATE,
    ROOMMATE,
    MENTOR,
    STUDENT,
    RIVAL;

    private static final Random RANDOM = new Random();

    public static RelationType getRandomRelation() {
        RelationType[] relations = RelationType.values();
        return relations[RANDOM.nextInt(relations.length)];
    }
}
