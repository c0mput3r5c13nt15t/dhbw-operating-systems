#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

#define LOCKFILE ".lock"

int main(int argc, char *argv[]) {
    int lock;
    FILE *file;

    lock = open(LOCKFILE, O_WRONLY | O_CREAT | O_EXCL);
    if (lock == -1) {
        if (errno == EEXIST) {
            printf("Ressource ist bereits gesperrt!\n");
        } else {
            perror("Fehler beim Erzeugen des Lockfiles");
        }
        exit(EXIT_FAILURE);
    }

    printf("Lock gesetzt.\n");

    file = fopen(argv[1], "w+");

    sleep(1);

    fprintf(file, "Start write\n");

    sleep(5);

    fprintf(file, argv[2]);

    sleep(5);

    fprintf(file, "\nEnd write\n");

    sleep(1);

    fclose(file);

    close(lock);
    unlink(LOCKFILE);
    printf("Lock wieder freigegeben.\n");

    return 0;
}
