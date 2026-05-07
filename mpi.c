#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[])
{

    MPI_Init(&argc, &argv);

    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int data[100]; // max size (safe)
    int part[5];   // each process gets 5 numbers
    int sum = 0, total = 0;

    if (rank == 0)
    {
        printf("Enter %d numbers:\n", 5 * size);
        for (int i = 0; i < 5 * size; i++)
        {
            scanf("%d", &data[i]);
        }
    }

    MPI_Scatter(data, 5, MPI_INT, part, 5, MPI_INT, 0, MPI_COMM_WORLD);

    for (int i = 0; i < 5; i++)
    {
        sum += part[i];
    }

    printf("Process %d sum = %d\n", rank, sum);

    MPI_Reduce(&sum, &total, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0)
    {
        printf("Final Sum = %d\n", total);
    }

    MPI_Finalize();
    return 0;
}

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    MPI_Init(&argc, &argv);

    int rank, size;

    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int data[4];
    int part[2];

    int sum = 0;
    int finalsum = 0;

    // Input by root process
    if (rank == 0)
    {
        printf("Enter 4 numbers:\n");

        for (int i = 0; i < 4; i++)
        {
            scanf("%d", &data[i]);
        }
    }

    // Divide data
    MPI_Scatter(data, 2, MPI_INT, part, 2, MPI_INT, 0, MPI_COMM_WORLD);

    // Local sum
    for (int i = 0; i < 2; i++)
    {
        sum += part[i];
    }

    // Print process sums in order
    for (int i = 0; i < size; i++)
    {
        if (rank == i)
        {
            printf("Process %d sum = %d\n", rank, sum);
        }

        MPI_Barrier(MPI_COMM_WORLD);
    }

    // Combine sums
    MPI_Reduce(&sum, &finalsum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    // Ensure all process outputs complete
    MPI_Barrier(MPI_COMM_WORLD);

    // Final output
    if (rank == 0)
    {
        printf("Final Sum = %d\n", finalsum);
    }

    MPI_Finalize();

    return 0;
}
    MPI_Finalize();
    return 0;
}
