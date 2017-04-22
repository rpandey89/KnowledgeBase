package com.knowledgebase.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 4/3/17.
 */
public class FirstMissingInteger {
    private static void moveElements(ArrayList<Integer> a, int index) {
        if (index == a.size()) {
            return;
        } else {
            int num = a.get(index);
            if (num > 0 && num < a.size() && num - 1 != index && a.get(index) != a.get(num - 1)) {
                Collections.swap(a, num - 1, index);
                moveElements(a, index);
            } else {
                moveElements(a, index + 1);
            }
        }
    }

    private static int firstMissingPositive(ArrayList<Integer> a) {
        /*if (a.size() == 0) return 1;
        int j =0;
        for(int i=0;i<a.size();i++) {
            if(a.get(i) <= 0) {
                Collections.swap(a, i, j);
                a.set(j, 0);
                j++;
            }
        }
        moveElements(a, j);
        int num = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) - 1 != i) {
                num = i;
                break;
            }
        }
        return num >= 0 ? num + 1 : a.size() + 1;*/
        if (a.size() == 0) return 1;
        //moveElements(a, 0);
        //move all the negative elements at the front
        int j =0;
        for(int i=0;i<a.size();i++) {
            if(a.get(i) <= 0) {
                Collections.swap(a, i, j);
                a.set(j, 0);
                j++;
            }
        }

        //now place -1 at the indexes corresponding to which numbers are already present
        for(int i=j;i<a.size();i++) {
            if(a.get(i) <= a.size() && a.get(i) > 0) {
                while(a.get(i) != i+1) {
                    //break if the element is negative or greater than array size
                    if(a.get(i) > a.size() || a.get(i) <= 0) break;
                    //break if duplicate and already there
                    if(a.get(i) == a.get(a.get(i) - 1)) break;
                    int temp = a.get(i);
                    a.set(i, a.get(temp-1));
                    a.set(temp - 1, temp);
                }
            }
        }
        //search for first non-positive number that index + 1 will be the missing number
        int num = a.size();
        for (int i = 0; i < a.size(); i++) {
            //check when value is not index + 1 which means number is present
            if (a.get(i) != i + 1) {
                num = i;
                break;
            }
        }
        return num == a.size() ?  a.size() + 1 : num + 1;
    }

    public static void main(String[] args) {
        //Integer[] a = {1, 2, 2};
        //Integer[] a = {417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327};
        //Integer[] a = {1};
        //Integer[] a = {699, 2, 690, 936, 319, 784, 562, 35, 151, 698, 126, 730, 587, 157, 201, 761, 956, 359, 198, 986, 915, 7, 703, 324, 814, 382, 294, 204, 120, 731, 615, 330, 486, 52, 223, 376, 649, 458, 564, 971, 72, 605, 177, 20, 461, 790, 872, 363, 916, 435, 991, 184, 410, 320, 16, 480, 768, 801, 117, 338, 650, 786, 17, 369, 979, 304, 445, 688, 862, 229, 311, 351, 985, 697, 135, 299, 310, 3, 643, 221, 831, 196, 887, 679, 484, 209, 824, 292, 588, 721, 140, 675, 827, 913, 271, 170, 812, 552, 334, 860, 981, 550, 308, 584, 442, 328, 251, 456, 976, 31, 507, 954, 982, 742, 45, 727, 794, 309, 527, 623, 56, 843, 436, 681, 143, 130, 689, 870, 362, 580, 560, 474, 385, 525, 881, 51, 890, 917, 820, 826, 139, 443, 978, 144, 512, 205, 682, 188, 344, 429, 497, 181, 749, 864, 664, 145, 621, 629, 886, 572, 89, 725, 945, 29, 553, 977, 783, 590, 236, 728, 125, 90, 492, 261, 543, 259, 662, 622, 285, 392, 561, 670, 200, 504, 246, 513, 910, 583, 460, 179, 207, 709, 127, 926, 816, 426, 520, 174, 464, 883, 780, 5, 268, 606, 1, 109, 704, 391, 661, 924, 516, 241, 477, 952, 405, 522, 247, 335, 356, 839, 423, 779, 4, 43, 720, 238, 965, 951, 914, 10, 496, 775, 651, 788, 373, 491, 746, 799, 518, 93, 86, 774, 652, 955, 494, 252, 781, 946, 412, 202, 741, 719, 612, 673, 896, 1000, 289, 554, 69, 424, 980, 506, 593, 889, 25, 959, 28, 736, 8, 969, 865, 657, 567, 434, 9, 167, 357, 929, 645, 250, 565, 94, 928, 473, 509, 823, 313, 762, -1, 208, 903, 922, 655, 948, 326, 485, 150, 73, 505, 225, 122, 129, 648, 838, 811, 972, 735, 78, 428, 740, 782, 632, 316, 440, 737, 297, 873, 281, 479, 654, 0, 633, 212, 152, 154, 470, 866, 79, 722, 958, 732, 900, 832, 278, 58, 842, 745, 540, 169, 347, 592, 438, 882, 462, 53, 34, 519, 489, 85, 757, 919, 701, 15, 211, 667, 637, 74, 573, 240, 559, -2, 472, 203, 112, 162, 776, -4, 155, 837, 99, 98, 64, 101, 983, 366, 853, 970, 482, 40, 921, 374, 758, 413, 339, 705, 771, 360, 734, 282, 219, 766, 535, 133, 532, 254};
        Integer[] a = {581, 366, 930, 829, 192, 275, 575, 654, 937, 774, 864, 910, 519, 685, 86, 841, 595, 954, 1000, 720, 925, 400, 897, 351, 46, 877, 733, 793, 971, 577, 380, 60, 166, 797, 744, 231, 732, 642, 410, 421, 53, 65, 422, 301, 798, 911, 698, 935, 525, 682, 828, 25, 250, 356, 452, 200, 134, 293, 514, 14, 544, 906, 467, 101, 783, 786, 803, 210, 211, 880, 172, 485, 639, 66, 724, 920, 764, 345, 612, 520, 888, 529, 368, 56, 238, 770, 615, 159, 314, 740, 973, 404, 490, 267, 338, 19, 989, 271, 425, 865, 568, 686, 439, 480, 943, 904, 276, 878, 762, 120, 29, 814, 712, 191, 500, 161, 846, 889, 251, 635, 258, 941, 396, 677, 627, 702, 282, 503, 497, 801, 184, 162, 158, 51, 541, 749, 336, 372, 540, 629, 647, 824, 548, 700, 434, 928, 845, 157, 360, 77, 982, 791, 340, 8, 155, 182, 551, 476, 725, 709, 921, 761, 823, 730, 505, 856, 269, 257, 589, 866, 125, 765, 608, 643, 265, 67, 76, 553, 462, 986, 822, 441, 779, 967, 616, 944, 645, 225, 534, 852, 283, -1, 657, 205, 907, 813, 102, 96, 692, 851, 12, 408, 672, 847, 26, 651, 216, 962, 689, 411, 156, 628, 659, 715, 295, 707, 209, 178, 902, 337, 428, 555, 494, 5, 83, 722, 137, 957, 229, 92, 247, 696, 450, 528, 976, 323, 631, 914, 795, 346, 604, 539, 585, 763, 261, 286, 387, 488, 226, 349, 546, 429, 486, 699, 543, 32, 590, 810, 901, 680, 405, 126, 946, 133, 264, 508, 90, 636, 655, 208, 167, 796, 13, 311, 334, 228, 427, 552, 839, 253, 88, 754, 994, 243, 147, 507, 154, 903, 723, 22, 296, 924, 710, 717, 179, 979, 394, 767, 197, 755, 892, 444, 284, 958, 479, 818, 557, 392, 114, 776, 583, 926, 532, 24, 203, 719, 122, 186, 983, 919, 637, 775, 695, 820, 652, 50, 501, 727, 991, 859, 757, 2, 956, 938, 691, 128, 68, 565, 475, 968, 509, 236, 100, 536, 457, 138, 320, 726, 614, 950, 697, 735, 649, 54, 807, 862, 554, 379, 849, 912, 308, 491, 11, 656, 412, 891, 587, 124, 562, 129, 526, 466, 857, 419, 55, 738, 934, 693, 790, 294, 326, 952, 808, 185, 312, 598, 135, 73, 242, 868};
        System.out.println(firstMissingPositive(new ArrayList<>(Arrays.asList(a))));
    }
}