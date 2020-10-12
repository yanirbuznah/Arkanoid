package game;

/**
 * The type game.Consts.
 * class with the all consts in the program.
 */
public class Consts {
    //Game gui consts
    public static final int W_WIDTH = 800;
    public static final int W_HEIGHT = 600;
    public static final int BLOCK_WIDTH = 50;
    public static final int BLOCK_HEIGHT = 20;
    public static final int BLOCKS_START_X = 725;
    public static final int BLOCKS_START_Y = 200;
    public static final int BORDER_SIZE = 25;
    public static final int SCREEN_MIDDLE = 350;

    //sprites.Paddle consts
    public static final int BORDER_WIDTH = 25;
    public static final int SCREEN_WIDTH = 800;
    public static final int PADDLE_SPEED = 10;
    public static final int PADDLE_HEIGHT = 10;
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_EDGE_RADIUS = PADDLE_HEIGHT / 2;
     //animation.Animation
    public static final int SECOND_IN_MILLISECONDS = 1000;
    public static final int FRAME_PER_SECOND = 60;
     //levels
    public static final int FIRST_LEVEL = 1;
    public static final int NUMBER_OF_LEVELS = 4;
     //countdown screen
    public static final int COUNT_NUMBER = 3;
    public static final int X_CIRCLE_CENTER = 400;
    public static final int Y_CIRCLE_CENTER = 300;
    public static final int CIRCLE_RADIUS = 100;
    public static final int NUMBER_X_AXIS = 350;
    public static final int NUMBER_Y_AXIS = 370;
    public static final int NUMBER_FONT_SIZE = 200;
    public static final int IMAGE_UPPERLEFT_X_AXIS = 300;
    public static final int IMAGE_UPPERLEFT_Y_AXIS = 200;
    public static final int TEXT_X_AXIS = 300;
    public static final int TEXT_Y_AXIS = 300;
    public static final double SLEEPER_PAUSE = 0.5;
     //End screen
    public static final int X_AXIS_START_OF_MESSAGE = 150;
    public static final int Y_AXIS_START_OF_MESSAGE = 570;
    public static final int MESSAGE_FONT_SIZE = 40;
     //Game flow
    public static final int LIVES = 5;
    public static final int FINISH_LEVEL_BONUS = 100;
     //levels
    public static final int START_ANGLE_VELOCITY = 310;
    public static final int SPEED_VELOCITY = 5;
     //level 1
    public static final int LVL1_NUMBER_OF_BALLS = 1;
    public static final int LVL1_DX_VELOCITY = 0;
    public static final int LVL1_DY_VELOCITY = -10;
    public static final int LVL1_BLOCK_UPPER_LEFT_X = 385;
    public static final int LVL1_BLOCK_UPPER_LEFT_Y = 135;
    public static final int LVL1_BLOCK_WIDTH = 30;
    public static final int LVL1_BLOCK_HEIGHT = 30;
    public static final int LVL1_NUMBER_OF_BLOCKS = 1;
     //level 2
    public static final int LVL2_NUMBER_OF_BALLS = 10;
    public static final int LVL2_VELOCITY_ANGLE_STEP = 11;
    public static final int LVL2_PADDLE_WIDTH = 700;
    public static final int LVL2_BLOCK_UPPER_LEFT_Y = 250;
    public static final int LVL2_NUMBER_OF_BLOCKS = 15;
     //level 3
    public static final int LVL3_NUMBER_OF_BALLS = 2;
    public static final int LVL3_VELOCITY_ANGLE_STEP = 90;
    public static final int LVL3_BLOCKS_BIGGEST_COLUMNS = 10;
    public static final int LVL3_BLOCKS_ROWS = 5;
    public static final int LVL3_NUMBER_OF_BLOCKS = 40;
     //level 4
    public static final int LVL4_NUMBER_OF_BALLS = 3;
    public static final int LVL4_VELOCITY_ANGLE_STEP = 45;
    public static final int LVL4_BLOCKS_COLUMNS = 15;
    public static final int LVL4_BLOCKS_ROWS = 7;
    public static final int LVL4_NUMBER_OF_BLOCKS = LVL4_BLOCKS_COLUMNS * LVL4_BLOCKS_ROWS;
    public static final int NAME_X_AXIS = 600;
    public static final int NAME_Y_AXIS = 15;
    public static final int NAME_SIZE = 15;
     //level1 Background
    public static final int TARGET_X_CENTER = 400;
    public static final int TARGET_Y_CENTER = 150;
    public static final int INNER_TARGET_RADIUS = 60;
    public static final int MIDDLE_TARGET_RADIUS = 80;
    public static final int EXTERNAL_TARGET_RADIUS = 100;
    public static final int START_Y_LINE = 50;
    public static final int END_Y_LINE = 250;
    public static final int START_X_LINE = 300;
    public static final int END_X_LINE = 500;
     //level2 Background
    public static final int SUN_CENTER = 150;
    public static final int INNER_SUN_RADIUS = 50;
    public static final int MIDDLE_SUN_RADIUS = 60;
    public static final int EXTERNAL_SUN_RADIUS = 70;
    public static final int MOON_RADIUS = 50;
    public static final int EXTERNAL_SUN_COLOR = 0xEFE7B0;
    public static final int MIDDLE_SUN_COLOR = 0XECD749;
    public static final double SUN_AND_MOON_VELOCITY = 1.5;
    public static final int[] STAR_RADIUS = {15, 5, 11, 5};
    public static final int NUMBER_OF_POLYGON_POINTS = 16;
    public static final int NUMBER_OF_STARS = 20;
    public static final int STARS_SCOPE = 10;
    public static final int STARS_EDGE_MOD = 4;
     //level 3 Background
    public static final int BUILDING_UPPER_LEFT_X = 100;
    public static final int BUILDING_UPPER_LEFT_Y = 400;
    public static final int BUILDING_WIDTH = 120;
    public static final int BUILDING_HEIGHT = 200;
    public static final int POLL_COLOR = 0xFF2D2C2C;
    public static final int POLL_UPPER_LEFT_X = 140;
    public static final int POLL_UPPER_LEFT_Y = 300;
    public static final int POLL_WIDTH = 40;
    public static final int POLL_HEIGHT = 100;
    public static final int ANTENNA_UPPER_LEFT_X = 155;
    public static final int ANTENNA_UPPER_LEFT_Y = 200;
    public static final int ANTENNA_WIDTH = 10;
    public static final int ANTENNA_HEIGHT = 100;
    public static final int WINDOWS_COLUMNS = 4;
    public static final int WINDOWS_ROWS = 4;
    public static final int WINDOWS_START_X = 105;
    public static final int WINDOWS_START_Y = 405;
    public static final int WINDOW_WIDTH = 20;
    public static final int WINDOW_HEIGHT = 40;
    public static final int WINDOWS_SPACE = 10;
    public static final int BULB_X_CENTER = 160;
    public static final int BULB_Y_CENTER = 200;
    public static final int BULB_EXTERNAL_RADIUS = 15;
    public static final int BULB_MIDDLE_RADIUS = 10;
    public static final int BULB_INNER_RADIUS = 5;
    public static final int ON_OFF_FRAMES = 10;
    public static final int LVL3_BACKGROUND_COLOR = 0X2A8215;
     //level 4 Background
    public static final int NUMBER_OF_BALLOONS = 5;
    public static final int BALLOONS_MAX_RADIUS = 50;
    public static final int BALLOONS_MIN_RADIUS = 20;
    public static final int BALLOONS_X_DIFFERENCE = 20;
    public static final int BALLOONS_Y_DIFFERENCE = 10;
    public static final int BALLOONS_DY_VELOCITY = -1;
    public static final int SUN_X_AXIS_CENTER = 150;
    public static final int SUN_Y_AXIS_CENTER = 120;
    public static final int LVL4_INNER_SUN_RADIUS = 30;
    public static final int LVL4_MIDDLE_SUN_RADIUS = 40;
    public static final int LVL4_EXTERNAL_SUN_RADIUS = 50;
    public static final int LVL4_MIDDLE_SUN_COLOR = 0XECD749;
    public static final int LVL4_EXTERNAL_SUN_COLOR = 0xEFE7B0;
    public static final int WIRES_LENGTH = 200;
    public static final int SUN_RAYS_SPACES = 10;
    public static final int SUN_RAYS = 100;
    public static final int SUN_RAY_COLOR = 0xEFE7B0;
    public static final int LVL4_SKY_COLOR = 0X1788D0;
    public static final int QUOTE_X_AXIS = 50;
    public static final int QUOTE_Y_AXIS = 300;
    public static final int QUOTE_FONT_SIZE = 35;
    public static final int ROCKY_X_AXIS = 600;
    public static final int ROCKY_Y_AXIS = 340;
    public static final int ROCKY_FONT_SIZE = 20;
     //lives indicator
    public static final int LIVES_X_AXIS = 100;
    public static final int LIVES_X_AXIS_INDICATOR = 200;
    public static final int LIVES_Y_AXIS = 15;
    public static final int LIVES_FONT_SIZE = 15;
    public static final int LIVES_IMAGE_X_AXIS = 150;
    public static final int LIVES_IMAGE_Y_AXIS = 2;
    public static final int LIVES_IMAGE_SIZE = 20;
     //pause screen
    public static final int PAUSE_BACKGROUND = 0xD9E9F5;
    public static final int PAUSE_X_AXIS = 10;
    public static final int PAUSE_Y_AXIS = 580;
    public static final int PAUSE_FONT_SIZE = 32;
}